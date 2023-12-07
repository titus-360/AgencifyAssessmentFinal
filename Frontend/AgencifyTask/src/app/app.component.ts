// import { Component } from '@angular/core';
//
// @Component({
//   selector: 'app-root',
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.css']
// })
// export class AppComponent {
//   title = 'AgencifyTask';
// }
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <div>
      <h1>Agencify Asessment </h1>
      <nav>
        <a routerLink="/phone-numbers">Phone Numbers</a>
        <a routerLink="/add-phone-number">Add Phone Number</a>
      </nav>
      <router-outlet></router-outlet>
    </div>
  `,
  styles: [`
    h1 {
      color: #333;
    }
    nav {
      background-color: #f0f0f0;
      padding: 10px;
      margin-bottom: 20px;
    }
    nav a {
      margin-right: 10px;
      text-decoration: none;
      color: #333;
      font-weight: bold;
    }
  `]
})
export class AppComponent {}


