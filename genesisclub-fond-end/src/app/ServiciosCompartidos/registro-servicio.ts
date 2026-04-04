import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RegistroServicio {

  constructor(
    private http: HttpClient
  ){}


  private urlRegistro= 'http://localhost:8080/registro/nuevo';
  private urlRegistroEmpleado = 'http://localhost:8080/registro/nuevo';

   crearCliente(
    nombre: string,
    apellido: string,
    email: string,
    password: string,
    codigoArea: string,
    numeroCel: string,
    direccion: string,
    rol: string
  ): Observable<any> {

    const body = {
      nombre,
      apellido,
      email,
      password,
      codigoArea,
      numeroCel,
      direccion,
      rol
    };

    return this.http.post<any>(this.urlRegistro, body); // ✅ RETURN + body directo
  }

  crearEmpleado(
    nombre: string,
    apellido: string,
    email: string,
    password: string,
    codigoArea: string,
    numeroCel: string,
    dni: string,
    fechaNacimiento: string,
    cargo: string,
    rol: string
  ): Observable<any> {

    const body = {
      nombre,
      apellido,
      email,
      password,
      codigoArea,
      numeroCel,
      dni,
      fechaNacimiento,
      cargo,
      rol
    };

    return this.http.post<any>(this.urlRegistroEmpleado, body); // ✅ RETURN + body directo
  }
}
  
