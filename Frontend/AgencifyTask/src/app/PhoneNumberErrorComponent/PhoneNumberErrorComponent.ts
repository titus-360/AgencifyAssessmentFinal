import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-phone-number-error',
  template: `
    <div *ngIf="errorMessage" class="error-message">
      {{ errorMessage }}
    </div>
  `,
  styles: [
    '.error-message { color: red; font-weight: bold; }',
  ],
})
export class PhoneNumberErrorComponent {
  @Input() errorMessage: string | null = null;
}
