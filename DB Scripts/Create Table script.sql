CREATE TABLE libraryitems (
	barcode SERIAL PRIMARY KEY,
	checkouttime INT,
	copiesavailable INT,
	itemlength VARCHAR, --pages, time
	ilocation VARCHAR,
	title VARCHAR
);

CREATE TABLE book(
	barcode INT,
	FOREIGN KEY (barcode)
		REFERENCES libraryitems (barcode),
	genre VARCHAR,
	author VARCHAR,
	summary VARCHAR,
	agerange VARCHAR --Adult, teen, child
);

CREATE TABLE audiobook(
	barcode INT,
	FOREIGN KEY (barcode)
		REFERENCES libraryitems (barcode),
	speaker VARCHAR
);

CREATE TABLE research(
	barcode INT,
	FOREIGN KEY (barcode)
		REFERENCES libraryitems (barcode),
	publishdate INT,
	topic VARCHAR,
	publisher VARCHAR,
	researchtype VARCHAR -- textbook, magazine, newspaper
);

CREATE TABLE digital(
	barcode INT,
	FOREIGN KEY (barcode)
		REFERENCES libraryitems (barcode),
	genre VARCHAR,
	creator VARCHAR,
	digitaltype VARCHAR, -- movies, music, video games
	description VARCHAR
);