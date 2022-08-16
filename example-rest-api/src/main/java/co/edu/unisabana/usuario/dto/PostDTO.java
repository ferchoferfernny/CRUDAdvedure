package co.edu.unisabana.usuario.dto;

import lombok.*;

//Explicar lombok
@Data
public class PostDTO
{
    String name;
    String date;
    String content;
    String image;
    int price;
    String nit;

    public PostDTO(String name, String date, String content, String image, int price, String nit)
    {
        this.name = name;
        this.date = date;
        this.content = content;
        this.image = image;
        this.price = price;
        this.nit= nit;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}