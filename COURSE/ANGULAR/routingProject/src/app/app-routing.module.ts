import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HrhelpdeskComponent } from './hrhelpdesk/hrhelpdesk.component';
import { LearningComponent } from './learning/learning.component';
import { PayrollComponent } from './payroll/payroll.component';
import { ProfileComponent } from './profile/profile.component';
import { TechComponent } from './tech/tech.component';

const routes: Routes = [
  {path:"",redirectTo:"/home",pathMatch:"full"},
  {path:"home",component:HomeComponent},
  {path:"profile",component:ProfileComponent},
  {path:"hr",component:HrhelpdeskComponent},
  {path:"learning",component:LearningComponent},
  {path:"learning/:technology",component:TechComponent},
  {path:"payroll",component:PayrollComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
