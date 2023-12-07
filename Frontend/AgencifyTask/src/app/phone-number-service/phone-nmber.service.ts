import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PhoneNumberService {
  private baseUrl = 'http://localhost:8080/api/phone-numbers';

  constructor(private http: HttpClient) {
  }

  getAllPhoneNumbers(page: number, size: number): Observable<any> {
    const params = new HttpParams().set('page', page.toString()).set('size', size.toString());
    return this.http.get(`${this.baseUrl}`, {params});
  }

  getFilteredPhoneNumbers(
    page: number,
    size: number,
    country?: string,
    state?: string
  ): Observable<any> {
    let params = new HttpParams().set('page', page.toString()).set('size', size.toString());
    if (country) {
      params = params.set('country', country);
    }
    if (state) {
      params = params.set('state', state);
    }
    return this.http.get(`${this.baseUrl}/filter`, {params});
  }

  createPhoneNumber(phoneNumber: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, phoneNumber);
  }

  private handleError(error: any) {
    if (error.status === 400) {
      // Bad Request, possibly an invalid phone number or country
      return throwError(error.error);
    } else {
      console.error('An error occurred:', error);
      return throwError('An unexpected error occurred. Please try again later.');
    }
  }
  }
