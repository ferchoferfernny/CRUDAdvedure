package co.edu.unisabana.usuario.controller;

import co.edu.unisabana.usuario.dto.SuplierDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SuplierController
{

    public List<SuplierDTO> dataStartSuplier()
    {
        List<SuplierDTO> list = new ArrayList<>();
        list.add(new SuplierDTO("Tierra bomba", "192123", "Deportes extremos", "123"));
        list.add(new SuplierDTO("Aventura", "192456", "Deportes familiares", "456"));
        list.add(new SuplierDTO("Explora", "192789", "Deportes extremos", "789"));
        list.add(new SuplierDTO("Bogotá Extrema", "c", "Deportes familiares", "012"));

        return list;
    }
    public List<SuplierDTO> localList=dataStartSuplier();


    @GetMapping("/login/{nit}")
    //@Override
    public List<SuplierDTO> read (@PathVariable String nit)
    {
        List<SuplierDTO> resultados = new ArrayList<>();
        localList.forEach(data ->
        {
            if (data.getNit().contains(nit))
            {
                resultados.add(data);
                this.ok();
            }
        });
        if (resultados.isEmpty()){
            this.notFound();
        }

        return resultados;
    }

    

    @GetMapping("/createEnterprise")
    public SuplierDTO create(@RequestParam String name, @RequestParam String nit,@RequestParam String category,@RequestParam String password)
    {
        SuplierDTO x=new SuplierDTO(name,nit,category,password);
        localList.add(x);
        return x;
    }

    //Este metodo elimina una empresa y todas la spubliaciones que tenga asociadas 
    @GetMapping ("/deleteEnterprise")
    public void delete(@RequestParam String nit)
    {
        localList.removeIf(t -> nit.equals(t.getNit()));
        PostController x = new PostController();
        x.deleteRelation(nit);
    }

    @GetMapping ("/updateEnterprise")
    public String update(@RequestParam String name, @RequestParam String nit,@RequestParam String category,@RequestParam String password)
    {
        SuplierDTO x=new SuplierDTO(name,nit,category,password);
        localList.forEach(data ->
        {

            if (data.getNit().contains(nit))
            {
                data= x;
            }
        });
        return "Los datos fueron actualizados" ;

    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource was not found on the server")
    public String notFound() {
        return " El Codigo que busca no se encuntra Error 404";
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Resource was not found on the server")
    public String ok() {
        return "Se ha ejecutado correctamente la acción";
    }

}
