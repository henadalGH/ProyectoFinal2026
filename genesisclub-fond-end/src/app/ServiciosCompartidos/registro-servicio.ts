import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RegistroServicio {

  private urlRegistro = 'http://localhost:8080/registro/nuevo';


  constructor(private http: HttpClient){}

  crearCliente(nombre: string, apellido: string, email: string, password: string, codigoArea: string, 
    numero: string, direccion:string, rol: string
  ){
    return this.http.post<any>(this.urlRegistro, {nombre, apellido, email, password, codigoArea, numero, direccion, rol})
  }

  crearEmpleado(nombre: string, apellido: string, email: string, password: string, codigoArea: string, 
    numero: string, rol: string, dni: string, fechaNacimiento: string, cargo: string
  ){
    return this.http.post<any>(this.urlRegistro, {nombre, apellido, email, password, codigoArea, numero, rol, 
      dni, fechaNacimiento, cargo})
  }

  
}
