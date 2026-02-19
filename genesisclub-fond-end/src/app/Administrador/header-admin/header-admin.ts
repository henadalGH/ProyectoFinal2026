import { Component } from '@angular/core';
import { AuthServicio } from '../../ServiciosCompartidos/auth-servicio';

@Component({
  selector: 'app-header-admin',
  imports: [],
  templateUrl: './header-admin.html',
  styleUrl: './header-admin.css',
})
export class HeaderAdmin {

  constructor(private authServicio: AuthServicio) {}
  
    logout() {
      this.authServicio.logout();
    }

}
