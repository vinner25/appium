import { Component,OnInit } from '@angular/core';
import { Hero } from './hero';
import { HeroService } from './hero.service';

@Component({
  selector: 'my-app',
  templateUrl: 'app.component.html'    
,
styles: [`
  
`],
providers: [HeroService]
})

	
export class AppComponent implements OnInit {
  heroes: Hero[];
  title = 'Tour of Heroes';
  selectedHero: Hero;

  constructor(private heroService: HeroService){}
  
  getHeroes(): void {
    this.heroService.getHeroes().then(heroes => this.heroes = heroes);
  }

  ngOnInit(): void{
    this.getHeroes();
  }
  
  onSelect(hero: Hero): void {
	     this.selectedHero = hero;
  }
}