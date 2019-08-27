import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {

    public parkingForm: any;
    private API = 'http://localhost:8081/api/parkings';
    constructor(private http: HttpClient) { }

    getAllParking(): Observable<parkingForm[]> {
        return this.http.get<IProduct[]>(this.API)
            .pipe(
            tap(data => console.log('All: ' + JSON.stringify(data))),
            catchError(this.handleError)
            );
    }

    calculateAmount(event: any): Observable<any> {
        return this.http.post(this.API, event.target.value)
            .pipe(
            tap(data => console.log('All: ' + JSON.stringify(data))),
            catchError(this.handleError)
            );
    }

        
        parkVehicle(): Observable<any> {
        return this.http.post(this.API, parking)
            .pipe(
            tap(data => console.log('All: ' + JSON.stringify(data))),
            catchError(this.handleError)
            );
    }
    private handleError(err: HttpErrorResponse) {
        let errorMessage = '';
        if (err.error instanceof ErrorEvent) {
            errorMessage = `An error occurred: ${err.error.message}`;
        } else {
            errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
        }
        console.error(errorMessage);
        return throwError(errorMessage);
    }


}
