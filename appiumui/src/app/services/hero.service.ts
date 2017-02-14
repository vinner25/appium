//hero.service.ts
import { Injectable } from '@angular/core';
import { Hero } from '../common/hero';
import { HEROES } from '../common/mock-heroes';

@Injectable()
export class HeroService {
	getHeroes(): Promise<Hero[]> {
		return Promise.resolve(HEROES);
	}
}