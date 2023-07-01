import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app.component';
import { MyFirstComponentComponent } from './my-first-component/my-first-component.component';
import { DataBindingComponent } from './data-binding/data-binding.component';
import { NgForExampleComponent } from './ng-for-example/ng-for-example.component';
import { NgIfExampleComponent } from './ng-if-example/ng-if-example.component';
import { NgModelComponent } from './ng-model/ng-model.component';
import { FormsModule } from '@angular/forms';
import { ProductComponentComponent } from './product-component/product-component.component';
import { ProductService } from './product.service';
import { HttpClientModule } from '@angular/common/http';
import { GetRequestComponentComponent } from './get-request-component/get-request-component.component';
import { NgSwitchcaseComponent } from './ng-switchcase/ng-switchcase.component';
import { BuiltInPipesComponent } from './built-in-pipes/built-in-pipes.component';
import { AgePipe } from './age.pipe';
import { CustomPipeComponent } from './custom-pipe/custom-pipe.component';
import { ParameterizedPipeComponent } from './parameterized-pipe/parameterized-pipe.component';
import { FilterPipe } from './filter.pipe';
import { MultipleParameterPipeComponent } from './multiple-parameter-pipe/multiple-parameter-pipe.component';
import { TotalPipe } from './total.pipe';

@NgModule({
  declarations: [
    AppComponent,
    MyFirstComponentComponent,
    DataBindingComponent,
    NgForExampleComponent,
    NgIfExampleComponent,
    NgModelComponent,
    ProductComponentComponent,
    GetRequestComponentComponent,
    NgSwitchcaseComponent,
    BuiltInPipesComponent,
    AgePipe,
    CustomPipeComponent,
    ParameterizedPipeComponent,
    FilterPipe,
    MultipleParameterPipeComponent,
    TotalPipe
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
