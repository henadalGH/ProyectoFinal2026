import { Component } from '@angular/core';
import { Router, RouterLink } from "@angular/router";
import { RegistroServicio } from '../../ServiciosCompartidos/registro-servicio';
import { FormsModule } from "@angular/forms";

@Component({
  selector: 'app-registro-cliente',
  imports: [RouterLink, FormsModule],
  templateUrl: './registro-cliente.html',
  styleUrl: './registro-cliente.css',
})
export class RegistroCliente {

  constructor(private regClienteService: RegistroServicio,
    private router: Router
  ){}


  nombre: string = '';
  apellido: string = '';
  email: string = '';
  password: string = '';
  codigoArea: string = '';
  numero: string = '';
  direccion: string = '';
  rol: string = 'CLIENTE';

  registroCliente(){

    this.regClienteService.crearCliente(this.nombre, this.apellido, this.email, this.password, this.codigoArea, 
      this.numero, this.direccion, this.rol).subscribe({
        next : (respuesta: any)=>{
          this.router.navigate(['/inicio']);
        }
      })
  }

}
