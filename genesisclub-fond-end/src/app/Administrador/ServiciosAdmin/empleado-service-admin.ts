import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EmpleadoServiceAdmin {


  constructor(private http: HttpClient) { }


  ObteneEmpleados() {
    return this.http.get('http://localhost:8080/empleado');
  }

  deleteEmpleado(id: number) {
    return this.http.delete(`http://localhost:8080/empleados/${id}`);
  }

  bajaEmpleado(id: number) {
    return this.http.put(`http://localhost:8080/empleados/${id}/baja`, {});
  }

  getEmpleadoById(id: number) {
    return this.http.get(`http://localhost:8080/empleados/${id}`);
  }

  
}