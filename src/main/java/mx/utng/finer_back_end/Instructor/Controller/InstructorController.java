package mx.utng.finer_back_end.Instructor.Controller;
import mx.utng.finer_back_end.Instructor.Services.InstructorService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

     /**
     * Este método se encarga de hacer un registro en la tabla Usuario utilizando la función registrar_instructor.
     * Recibe los datos desde el frontend y los inserta en la base de datos.
     * 
     * @param nombre           Nombre del instructor
     * @param apellidoPaterno  Apellido paterno del instructor
     * @param apellidoMaterno  Apellido materno del instructor
     * @param correo           Correo electrónico del instructor
     * @param contrasenia      Contraseña del instructorgit 
     * @param nombreUsuario    Nombre de usuario del instructor
     * @param telefono         Telefono de usuario del instructor
     * @param direccion        Dirección del instructor
     * @param cedula           Cédula del instructor
     * @return Respuesta con el mensaje de éxito o error
     */
    @PostMapping("/crear-cuenta")
    public ResponseEntity<String> crearCuentainstructor(@RequestParam String nombre,
                                                    @RequestParam String apellidoPaterno,
                                                    @RequestParam String apellidoMaterno,
                                                    @RequestParam String correo,
                                                    @RequestParam String contrasenia,
                                                    @RequestParam String nombreUsuario,
                                                    @RequestParam String telefono,
                                                    @RequestParam String direccion,
                                                    @RequestParam MultipartFile cedula
                                                    ) {
        try {
            byte[] cedulaBytes = cedula.getBytes();
            ResponseEntity<String> mensaje = instructorService.registrarInstructor(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, nombreUsuario, telefono, direccion, cedulaBytes);
            return mensaje;
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error de conexión: " + e.getMessage());
        }
    }

    
}
