import {Component, Inject} from '@angular/core';
import {PhoneNumberService} from "../phone-number-service/phone-nmber.service";

@Component({
  selector: 'app-phone-number-add',
  templateUrl: './phone-number-add.component.html',
  styleUrls: ['./phone-number-add.component.css'],
})
export class PhoneNumberAddComponent {
  newPhoneNumber: any = {};
  responseMessage: string = '';
  successClass: string = '';
  errorClass: string = '';

  constructor(@Inject(PhoneNumberService) private phoneNumberService: PhoneNumberService) {
  }

  // addPhoneNumber() {
  //   this.phoneNumberService.createPhoneNumber(this.newPhoneNumber).subscribe(response => {
  //     // Handle success or error
  //     console.log(response);
  //   });
  // }

  // Method to add a new phone number
  addPhoneNumber() {
    this.phoneNumberService.createPhoneNumber(this.newPhoneNumber).subscribe(
      // Success callback
      (response) => {
        this.responseMessage = 'Phone number added successfully';
        this.successClass = 'text-success';
        this.errorClass = '';
      },
      // Error callback
      (error) => {
        this.responseMessage = 'Error adding phone number: ' + error.error.error;
        this.successClass = '';
        this.errorClass = 'text-danger';
      }
    );
  }
}

