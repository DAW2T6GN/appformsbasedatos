package pe.edu.cibertec.appformsbasedatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appformsbasedatos.model.response.ResultadoResponse;
import pe.edu.cibertec.appformsbasedatos.model.sp.EmpleadoSp;
import pe.edu.cibertec.appformsbasedatos.service.EmpleadoService;

@Controller
@RequestMapping("/Empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
    @GetMapping("/frmListarEmpleados")
    public String frmListarEmpleados(Model model){
        model.addAttribute("listaempleados",
                empleadoService.listarEmpleado());
        return "Empleado/frmMantEmpleado";
    }
    @PostMapping("/registrarEmpleado")
    @ResponseBody
    public ResultadoResponse registrarEmpleado(
            @RequestBody EmpleadoSp objEmpleado
            ){
        String mensaje = "Empleado registrado correctamente";
        Boolean respuesta = true;
        try{
            empleadoService.registrarEmpleado(objEmpleado);
        }catch (Exception ex){
            mensaje = "Empleado no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje)
                .respuesta(respuesta).build();
    }



}
