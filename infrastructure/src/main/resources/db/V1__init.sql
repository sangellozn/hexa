CREATE TABLE pizza (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	taille TEXT(12) NOT NULL,
	is_calzone INTEGER NOT NULL
);

CREATE TABLE ingredient (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	nom TEXT(50) NOT NULL,
	prix NUMERIC
);

CREATE TABLE pizza_has_ingredient (
	pizza_id INTEGER NOT NULL,
	ingredient_id INTEGER,
	CONSTRAINT pizza_has_ingredient_pk PRIMARY KEY (pizza_id, ingredient_id)
	CONSTRAINT pizza_has_ingredient_pizza_FK FOREIGN KEY (pizza_id) REFERENCES pizza(id) ON DELETE CASCADE,
	CONSTRAINT pizza_has_ingredient_ingredient_FK FOREIGN KEY (ingredient_id) REFERENCES ingredient(id) ON DELETE CASCADE
);

INSERT INTO ingredient (nom, prix) VALUES('Sauce tomate', 5);
INSERT INTO ingredient (nom, prix) VALUES('Crème fraiche', 5);
INSERT INTO ingredient (nom, prix) VALUES('Mozzarella', 2);
INSERT INTO ingredient (nom, prix) VALUES('Champignon', 2);
INSERT INTO ingredient (nom, prix) VALUES('Olive', 1);
INSERT INTO ingredient (nom, prix) VALUES('Pomme de terre', 2);
INSERT INTO ingredient (nom, prix) VALUES('Viande hachée', 2.5);
INSERT INTO ingredient (nom, prix) VALUES('Merguez', 2);
