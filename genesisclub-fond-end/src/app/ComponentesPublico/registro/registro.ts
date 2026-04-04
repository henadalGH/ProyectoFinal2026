import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RegistroServicio } from '../../ServiciosCompartidos/registro-servicio';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registro',
  imports: [FormsModule],
  standalone: true,
  templateUrl: './registro.html',
  styleUrl: './registro.css',
})
export class Registro {

  constructor(
    private registroServicio: RegistroServicio,
    private router: Router
  ){}

  nombre: string ='';
  apellido: string = '';
  email: string = '';
  password: string = '';
  direccion: string = '';
  codigoArea: string = '';
  numeroCel: string = '';
  rol: string = 'CLIENTE';


  registrarCliente() {
    return this.registroServicio.crearCliente(this.nombre, this.apellido, this.email, this.password, this.codigoArea,
      this.numeroCel, this.direccion, this.rol).subscribe(
        (Response)=>{
          this.router.navigate(['/inicio']);
        }
      )
    }
}
