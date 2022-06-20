package br.com.sinelacto.loja.api.v1;

import lombok.Data;

import java.net.URI;

@Data
public class UriResource {
    private String uri;

    public UriResource(URI path){
        this.uri=path.toString();
    }
}
