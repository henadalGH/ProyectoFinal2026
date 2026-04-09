import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RegistroServicio } from '../../../ServiciosCompartidos/registro-servicio';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-empleado',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './crear-empleado.html',
  styleUrl: './crear-empleado.css',
})
export class CrearEmpleado {


  constructor(private registroSer: RegistroServicio,
    private router: Router
  ){}

  nombre: string ='';
  apellido: string ='';
  email: string = '';
  password: string = '';
  codigoArea: string = '';
  numero: string = '';
  dni: string = '';
  fechaNacimiento: string= '';
  cargo: string = '';
  rol: string = 'EMPLEADO';


  creaEmpleado()
  {
    this.registroSer.crearEmpleado(this.nombre, this.apellido, this.email, this.password, this.codigoArea, this.numero,
      this.rol, this.dni,this.fechaNacimiento, this.cargo).subscribe({
        next: (repuesta: any )=> {
          this.router.navigate(['/listaEmpleado']);
        }});
  }

}
