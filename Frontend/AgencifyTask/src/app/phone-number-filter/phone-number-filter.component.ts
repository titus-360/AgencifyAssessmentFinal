import {Component, EventEmitter, Inject, Output} from '@angular/core';
import {PhoneNumberService} from "../phone-number-service/phone-nmber.service";


@Component({
  selector: 'app-phone-number-filter',
  templateUrl: './phone-number-filter.component.html',
  styleUrls: ['./phone-number-filter.component.css'],
})
export class PhoneNumberFilterComponent {
  @Output() filterChange = new EventEmitter<{ country: string; state: string }>();

  country: string = '';
  state: string = '';

  constructor(@Inject(PhoneNumberService) private phoneNumberService: PhoneNumberService) {
  }

  // Method to apply the filter and emit changes
  applyFilter() {
    this.filterChange.emit({country: this.country, state: this.state});
  }
}
