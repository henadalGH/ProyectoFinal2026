import { Routes } from '@angular/router';
import { Inicio } from './ComponentesPublico/inicio/inicio';
import { Login } from './ComponentesPublico/login/login';
import { RegistroCliente } from './ComponentesPublico/registro-cliente/registro-cliente';


export const routes: Routes = [

    //Rutas Compartidas
    {path:"inicio", component: Inicio},
    {path:"login", component: Login},
    {path:'', redirectTo: '/inicio', pathMatch: 'full'},
    {path:'registroCliente', component: RegistroCliente}

];
