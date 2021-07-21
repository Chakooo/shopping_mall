package com.shoppingMall.api;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shoppingMall.service.ProductService;
import com.shoppingMall.vo.ProductImageVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageFileController {
    @Autowired 
    ProductService service;
    @GetMapping("/image/{uri}")
    public ResponseEntity<Resource> getImage(@PathVariable String uri,HttpServletRequest request)throws Exception{
    // HttpServletRequest 가져온파일의 유형을 알아낼떄 쓴다.
    Path folderLocation = Paths.get("C:/Users/pch/Desktop/포트폴리오/images_save");

    String fileName =service.getProductImageFileName(uri);
    if(fileName==null){
        return null;
    }
    Path filePath = folderLocation.resolve(fileName).normalize();
    Resource r = new UrlResource(filePath.toUri());
    // Resource r= new UrlResource(filePath.toUri());

    String contentType = request.getServletContext().getMimeType(r.getFile().getAbsolutePath());
    if(contentType == null){
        contentType = "application/octet-stream";
    }

    return ResponseEntity.ok()
              .contentType(MediaType.parseMediaType(contentType))
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=\""+r.getFilename()+"\"")
              .body(r);

    }
    @PostMapping("/upload")
    public Map<String, Object> postFileUpload(@RequestPart MultipartFile file) { // 멤버메서드
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        Path folderLocation = Paths.get("C:/Users/pch/Desktop/포트폴리오/images_save");
        // StringUtils로 부터cleanPath 기능을 이용하여 파일의 경로를 가져온다
        // cleanPath는 운영체제 환경이 다를수있으니 한가지 표현방식으로 통일한다.
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // \\코드상 .을 표현하는 방법 , . 을 기준으로 문자열을 여러 문자열로 자른 후 문자열 배열에 저장한다.
        String[] splitFileName = fileName.split("\\.");

        // [splitFileName.length-1] 끝위치에 있는 파일명(배열요소)를 가져와서 ext변수에 저장
        String ext = splitFileName[splitFileName.length - 1];
        ext=ext.toLowerCase(); //ext값을 전체 소문자로 만든다.
        System.out.println(ext);
        // 허용항목이 jpg,jpeg,png,gif
        //equalsIgnoreCase (대소문자 관계없이 비교)같으면 true  /  다르면 false
        if(!ext.equalsIgnoreCase("jpg")&&!ext.equalsIgnoreCase("jpeg")&&!ext.equalsIgnoreCase("png")&&!ext.equalsIgnoreCase("gif")){
            resultMap.put("status",false);
            resultMap.put("message","jpg,jpeg,png,gif 파일만 등록가능합니다.");
            return resultMap;
        }

        System.out.println(fileName);
        System.out.println(ext);

        // 전송받은 파일을 저장할 때의 이름
        String saveFileName = null;
        Calendar c = Calendar.getInstance();

        String uriName =""+c.getTimeInMillis();
        saveFileName = uriName+ "." + ext;

        // resolve는 운영체제 환경이 다를수있으니 한가지 표현방식으로 통일한다.
        // String 을 file객체에서 사용가능한 path 형태로 변환
        Path target = folderLocation.resolve(saveFileName);

        try {
            // getInputStream>파일을 열어서 처음부터 읽는다. target 으로 복사한다 있으면 덮어쓰기
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            resultMap.put("status", false);
            resultMap.put("message", e.getMessage());
            return resultMap;
        }
        // Integer pi_seq = 6;
        String image_uri = "prod"+uriName;

        ProductImageVO pimgVO = new ProductImageVO();
        pimgVO.setPimg_file_name(saveFileName);
        pimgVO.setPimg_size((int) file.getSize());
        // pimgVO.setPimg_pi_seq(seq);
        pimgVO.setPimg_uri(image_uri);
        service.insertProductImage(pimgVO);

        resultMap.put("status", true);
        resultMap.put("message", "파일 업로드 완료");
        resultMap.put("image_uri",image_uri);
        return resultMap;
    }
}
