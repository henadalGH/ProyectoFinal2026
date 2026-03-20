import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HeaderAdmin } from "../../header-admin/header-admin";

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
}
