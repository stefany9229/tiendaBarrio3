package org.example.views;

import org.example.model.InventoryLine;
import org.example.model.Product;
import org.example.services.InventoryService;
import org.example.utils.SuperKeyBoard;

import java.io.IOException;

public class InveryView {

    private  InventoryService inventoryService;

    public InveryView(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public static void showSerchProduct() {

            System.out.println("""
                           BÚSQUEDA POR PRODCUTO
                           Ingrese la opcion que desea
                           1) Buscar producto por id
                           2) Buscar por prodcutos por nombre
                           """);
    }

    public  void showPrincipalMenyInventory(){
        System.out.println("""
                           BIENVENIDO A MI TIENDA DE BARRIO
                           Ingrese la opcion que desea
                           1) Ver todo el inventario
                           2) Buscar por pordcuto
                           """);
    }



    public  void selectOptions(){
        int option=SuperKeyBoard.readNumber();

        switch (option) {
            case 1:
                this.inventoryService.findAll().forEach(productInvetory -> printProduct(productInvetory));
                break;
            case 2:

                break;
            case 3:
                System.out.println("El número es 3");
                break;
            default:
                System.out.println("El número no es ni 1, ni 2, ni 3");
                break;
        }



    }

    private static void printProduct(InventoryLine productInventory){
        Product p= productInventory.getProduct();
        System.out.println("""
                ID: %d
                Nombre: %s
                Descripcion: %s
                Categoria: %s
                Tags: %s
                Precio: %.2f
                urlImagen: %s
                stock: %d
                """
                .formatted(p.getId(), p.getName(), p.getDescription(),p.getCategory(),p.getTags(),p.getPrice(),p.getImageUrl(), productInventory.getStock()));
    }

    private  Product findProduct() {

        this.showPrincipalMenyInventory();
        Integer option = SuperKeyBoard.readNumber();

        switch (option) {
            case 1:
                break;
            case 2:
                System.out.println("El número es 2");
                break;
            default:
            System.out.println("El número no es 1, 2, ni 3");
            break;
        }
        return null;
    }

        private  InventoryLine findProductById(Integer id){

            InventoryLine p= inventoryService.findByIdProduct(id);
            while(!p.equals(null)){
                System.out.println("No existe el producto");
                Integer idProduct=SuperKeyBoard.readNumber();
                p=inventoryService.findByIdProduct(id);
            }

            return  p;
        }












}
