import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HeaderAdmin } from "../../header-admin/header-admin";
import { RegistroServicio } from '../../../ServiciosCompartidos/registro-servicio';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-empleado',
  standalone: true,
  imports: [FormsModule, HeaderAdmin],
  templateUrl: './crear-empleado.html',
  styleUrl: './crear-empleado.css',
})
export class CrearEmpleado {

  nombre: string = '';
  apellido: string = '';
  email: string = ''
  password: string ='';
  codigoArea: string = '';
  numeroCel: string = '';
  dni: string = '';
  fechaNacimiento: string = '';
  cargo: string = '';
  rol: string = 'EMPLEADO';

  constructor(private registroService: RegistroServicio,
    private router: Router
  ){}


  registrarEmpleado() {
    return this.registroService.crearEmpleado(this.nombre, this.apellido, this.email, this.password, this.codigoArea, 
      this.numeroCel , this.dni, this.fechaNacimiento, this.cargo , this.rol).subscribe(
        (Response)=>{
          this.router.navigate(['/listaEmpleados']);
        }
      )
    }
}
