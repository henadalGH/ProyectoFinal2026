import { Component } from '@angular/core';
import { HeaderAdmin } from "../header-admin/header-admin";
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-inicio-admin',
  imports: [HeaderAdmin, RouterLink],
  templateUrl: './inicio-admin.html',
  styleUrl: './inicio-admin.css',
})
export class InicioAdmin {

}
