package co.edu.unisabana.usuario.dto;

import lombok.*;

//Explicar lombok
@Data
public class SuplierDTO
{
    String companyName;
    String nit;
    String category;
    String password;

    public SuplierDTO(String companyName, String nit, String category, String password)
    {
        this.companyName = companyName;
        this.nit = nit;
        this.category = category;
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
