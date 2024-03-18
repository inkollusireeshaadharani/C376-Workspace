import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SquarePipe } from './square.pipe';
import { AdharnoPipe } from './adharno.pipe';

@NgModule({
  declarations: [
    AppComponent,
    SquarePipe,
    AdharnoPipe
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
