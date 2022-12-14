package co.edu.unisabana.usuario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unisabana.usuario.dto.PostDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController
{

    public static List<PostDTO> dataStartPost()
    {
        List<PostDTO> list = new ArrayList<>();
        list.add(new PostDTO("Travesia Amazonica", "15/08/2022", "Visita el amazonas junto a nosotros! Vincúlate al plan Travesía amazónica y vive una experiencia inolvidable.", "",10000,"192123"));
        list.add(new PostDTO("Aventura Tirolesa", "20/07/2022", "Salta en tirolesa junto a nosotros! Vincúlate al plan Aventura Tirolesa y vive una experiencia inolvidable.", "",10000,"192123"));
        return list;
    }

    public static List<PostDTO> localListP=dataStartPost();



    
    @GetMapping("/login/{name}")
    //@Override
    public List<PostDTO> read (@PathVariable String name)
    {
        List<PostDTO> result = new ArrayList<>();
        localListP.forEach(data ->
        {
            if (data.getName().contains(name))
            {
                result.add(data);
            }
        });
        if (result.isEmpty()){
            this.notFound();
        }

        return result;
    }

    
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource was not found on the server")
    public String notFound() {
        return "";
    }

    @PostMapping("/createPost")
    public PostDTO create(@RequestParam String name,
                        @RequestParam String date,
                        @RequestParam String content,
                        @RequestParam String image,
                        @RequestParam int price,
                        @RequestParam String nit)
    {
        PostDTO x=new PostDTO(name,date,content,image,price,nit);
        localListP.add(x);
        return x;
    }
// metodo para eliminar un metodo de un 
    @DeleteMapping ("/deletePost/{nit}")
    public void delete(@RequestParam String name, @PathVariable String nit)
    {
        localListP.removeIf(t -> name.equals(t.getName()));
    }

    public void deleteRelation (String nit){

        localListP.removeIf(t -> nit.equals(t.getNit()));

    } 

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Resource was not found on the server")
    public String ok() {
        return "Se ha ejecutado correctamente la acción";
    }


// metodo para sobre escribir un registro 
    @PostMapping ("/updatePost")
    public String update(@RequestParam String name, 
                        @RequestParam String date,
                        @RequestParam String content, 
                        @RequestParam String image,
                        @RequestParam int price,
                        @RequestParam String nit)
    {
        PostDTO x=new PostDTO(name,date,content,image,price, nit);
        localListP.forEach(data ->
        {

            if (data.getName().contains(name))
            {
                data= x;
            }
        });
        return "Los datos fueron actualizados" ;

    }

}

