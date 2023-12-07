
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { PhoneNumberListComponent } from './phone-number-list/phone-number-list.component';
import { PhoneNumberFilterComponent } from './phone-number-filter/phone-number-filter.component';
import { PhoneNumberAddComponent } from './phone-number-add/phone-number-add.component';
import { PhoneNumberService } from './phone-number-service/phone-nmber.service';
import {PhoneNumberErrorComponent} from "./PhoneNumberErrorComponent/PhoneNumberErrorComponent";

const routes: Routes = [
  { path: '', redirectTo: '/phone-numbers', pathMatch: 'full' },
  { path: 'phone-numbers', component: PhoneNumberListComponent },
  { path: 'add-phone-number', component: PhoneNumberAddComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    PhoneNumberListComponent,
    PhoneNumberFilterComponent,
    PhoneNumberAddComponent,
    PhoneNumberErrorComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
  ],
  providers: [
    PhoneNumberService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
