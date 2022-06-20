package br.com.sinelacto.loja.api.v1.products;

import br.com.sinelacto.loja.api.v1.UriResource;
import br.com.sinelacto.loja.services.CloudinaryService;
import br.com.sinelacto.loja.services.ProductService;
import br.com.sinelacto.loja.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@RequestMapping("v1/products")
public class ProductController {

    private ProductService productService;

    private CloudinaryService cloudinaryService;
    private ProductResourceAssembler productResourceAssembler;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductResource getById(@PathVariable Long id) {
        return productResourceAssembler.toModel(productService.getById(id).orElseGet(Product::new));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ProductResource save(@RequestBody ProductResource bookResource) {
        return productResourceAssembler.toModel(productService.save(productResourceAssembler.fromModel(bookResource)));
    }

    @PostMapping(value = "/image", consumes= MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UriResource> uploadImage(@RequestParam("file")MultipartFile file){
        UriResource dto = new UriResource(cloudinaryService.store(file));
        return ResponseEntity.ok().body(dto);

    }


}
