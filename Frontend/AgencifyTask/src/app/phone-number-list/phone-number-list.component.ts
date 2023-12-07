import {Component, Inject, OnInit} from '@angular/core';
import {PhoneNumberService} from "../phone-number-service/phone-nmber.service";


@Component({
  selector: 'app-phone-number-list',
  templateUrl: './phone-number-list.component.html',
  styleUrls: ['./phone-number-list.component.css'],
})


export class PhoneNumberListComponent implements OnInit {
  phoneNumbers: any[] = [];
  currentPage: number = 0;
  pageSize: number = 10;
  totalPages: number = 0;

  constructor(@Inject(PhoneNumberService) private phoneNumberService: PhoneNumberService) {
  }


  ngOnInit() {
    // Load phone numbers when the component initializes
    this.loadPhoneNumbers();
  }

  // Method to load phone numbers from the service
  loadPhoneNumbers() {
    this.phoneNumberService.getAllPhoneNumbers(this.currentPage, this.pageSize).subscribe(
      // Success callback
      (data: any) => {
        if (data && data.content && Array.isArray(data.content)) {
          this.phoneNumbers = data.content;
        } else {
          console.error('Invalid data format. Expected an array in the "content" property:', data);
        }
      },
      // Error callback
      (error) => {
        console.error('Error loading phone numbers:', error);
      }
    );
  }


  // Method to handle page change and reload phone numbers

  onPageChange(page: number) {
    this.currentPage = page;
    this.loadPhoneNumbers();
  }
}
