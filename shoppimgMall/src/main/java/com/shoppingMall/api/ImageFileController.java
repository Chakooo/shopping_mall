package com.shoppingMall.api;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import com.shoppingMall.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageFileController {
    @Autowired 
    ProductService service;
    @GetMapping("/image/{uri}")
    public ResponseEntity<Resource> getImage(@PathVariable String uri,HttpServletRequest request)throws Exception{
    // HttpServletRequest 가져온파일의 유형을 알아낼떄 쓴다.
    Path folderLocation = Paths.get("C:/Users/pch/Desktop/포트폴리오/image");

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
    
}
