import { Component } from '@angular/core';
import { AuthServicio } from '../../ServiciosCompartidos/auth-servicio';

@Component({
  selector: 'app-header-cliente',
  imports: [],
  templateUrl: './header-cliente.html',
  styleUrl: './header-cliente.css',
})
export class HeaderCliente {

  constructor(private authServicio: AuthServicio) {}

  logout() {
    this.authServicio.logout();
  }

}
