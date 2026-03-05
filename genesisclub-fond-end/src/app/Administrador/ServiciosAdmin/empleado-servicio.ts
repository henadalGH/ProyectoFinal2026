import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EmpleadoServicio {

  private apiUrl = 'http://localhost:8080/api/empleado/todos';

  constructor(private http: HttpClient) {}

  obtenerEmpleado() {

    const token = localStorage.getItem('token');

    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });

    return this.http.get(this.apiUrl, {headers});
  }


  verEmpleado(id: number){

      const token = localStorage.getItem('token');

      const headers = new HttpHeaders({
        Authorization: `Bearer ${token}`
      });
      return this.http.get(`http://localhost:8080/api/empleado/${id}`, {headers});
  }



}