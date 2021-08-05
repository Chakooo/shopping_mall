package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.ProductImageVO;
import com.shoppingMall.vo.ProductInfoVO;
import com.shoppingMall.vo.ProductVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    
    public void insertProduct(ProductVO vo);

    public String getSellerName(Integer si_seq);
    public String getProductImageFileName(String uri);
    public String getCategoryName(Integer cate_seq);
    public ProductInfoVO selectProductBySeq(Integer seq);    
    public List<ProductInfoVO> selectProducts(Integer offset, String keyword, Integer category, Integer si_seq);
    public void insertProductImage(ProductImageVO vo);
    public List<ProductInfoVO> selectProductsByCategory(Integer cate_seq);
    public void updateProduct(ProductVO vo);
    public void deleteProduct(Integer seq);
    public ProductVO productBySeq(Integer seq);
    public List<String> selectProdNameBySeller(Integer si_seq);
    public List<ProductInfoVO> selectProductBySellerSeq(Integer si_seq);

    

    // insertProduct
    public Integer getLastSeq();

    //사업자 등록 상인seq ,  파일uri 등록
    public void insertSellerRegistImage(Integer si_seq,String imageUri ,String saveFileName);
    

    
    
}
