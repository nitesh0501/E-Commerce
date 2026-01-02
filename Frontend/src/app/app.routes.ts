import { provideRouter, Routes } from '@angular/router';
import { SignupComponent } from './signup-component/signup-component';
import { LoginComponent } from './login-component/login-component';
import { ProductsComponent } from './product-component/product-component';

export const routes: Routes = [
    {path:'',component:SignupComponent},
    {path:'login',component:LoginComponent},
    {path:'product',component:ProductsComponent}
];
export const appRouter = provideRouter(routes);