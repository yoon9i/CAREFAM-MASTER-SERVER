package com.example.carefamserver.controllers;


import com.example.carefamserver.services.CreateService;
import com.example.carefamserver.services.InsertService;
import com.example.carefamserver.services.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class MainController {

    private Boolean firstUpdate = false;

    @Autowired
    private InsertService insertService;

    @Autowired
    private CreateService createService;

    @Autowired
    private SelectService selectService;

    @GetMapping("/insert")
    public String insert() throws IOException, SQLException {
        createService.dropSchema();
        createService.createSchema();
        createService.createTable();

        if (!firstUpdate) {
            insertService.saveDataToDB();
            insertService.saveDataToDB2();
            insertService.saveDataToDB3();
            insertService.saveDataToDB4();

            firstUpdate = true;
        }

        return "ok";
    }

    @GetMapping("/reset")
    public String reset() {
        createService.dropSchema();
        if (firstUpdate) {
            firstUpdate = false;
        }

        return "RESET COMPLETE";
    }

    @GetMapping("selectAll")
    public String select() {
        return "Mybatis개어렵다!!";
    }
}
