package org.generation.jpamysqlsample.controller;


import org.generation.jpamysqlsample.model.User;
import org.generation.jpamysqlsample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@CrossOrigin( "*" )
@RestController
public class UserController
{
    private final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }


    @GetMapping( "/user/{id}" )
    public User getUser( @PathVariable Integer id )
    {
        return userService.getUser( id );
    }
    @GetMapping("/user")
    public String saludo(){
        return "hola";
    }

    @PostMapping( "/user" )
    public User newUser( @RequestBody User user )
    {
        return userService.save( user );
    }

    @PutMapping( "/user" )
    public User updateUser( @RequestBody User user )
    {
        return userService.save( user );
    }

    @DeleteMapping( "/user/{id}" )
    public void deleteUser( @PathVariable Integer id )
    {
        userService.delete( id );
    }


    @GetMapping( "/user/search/{name}")
    public ArrayList<User> getUserSearch( @PathVariable String name ){

        return userService.findByName(name);
    }
}
