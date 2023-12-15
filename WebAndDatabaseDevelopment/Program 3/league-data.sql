USE league;

INSERT INTO parent VALUES
  ('Borg','James','450 Stone, Houston, TX','7132813468');
INSERT INTO parent VALUES
  ('Wong','Franklin','638 Voss, Houston, TX','7138323461');
INSERT INTO parent VALUES
  ('Wallace','Jennifer','291 Berry, Bellaire, TX','7375127260');
INSERT INTO parent VALUES
  ('James','Jared','123 Peachtree, Atlanta, GA','2294044704');
INSERT INTO parent VALUES
  ('Freed','Alex','4333 Pillsbury, Milwaukee, WI','2624145346');
INSERT INTO parent VALUES
  ('James','John','7676 Bloomington, Sacramento, CA','3104159492');

INSERT INTO player VALUES ('Borg','John','12',null,'7132813468',null);
INSERT INTO player VALUES ('Wong','Steve','10',null,'7138323461',null);
INSERT INTO player VALUES ('Wallace','Alex','10',null,'7375127260',null);
INSERT INTO player VALUES ('James','Larry','11',null,'2294044704',null);
INSERT INTO player VALUES ('Freed','Anthony','12',null,'2624145346',null);
INSERT INTO player VALUES ('James','Patrick','10',null,'3104159492',null);

INSERT INTO parent VALUES
  ('Smith','John','731 Fondren, Houston, TX','7135559088');
INSERT INTO parent VALUES
  ('Zelaya','Alicia','3321 Castle, Spring, TX','7134445675');
INSERT INTO parent VALUES
  ('Narayan','Ramesh','971 Fire Oak, Humble, TX','7134563232');

INSERT INTO coach VALUES ('Smith','Tyler','7137777800',null);
INSERT INTO coach VALUES ('Brown','Jarold','7134277765',null);
INSERT INTO coach VALUES ('Nelson','Jim','7132144432',null);

INSERT INTO team VALUES ('Jaguars','Red','7137777800');
INSERT INTO team VALUES ('Cheetahs','Green','7134277765');
INSERT INTO team VALUES ('Panthers','Blue','7132144432');

UPDATE player SET team = 'Panthers' WHERE fname = 'John';
UPDATE player SET team = 'Panthers' WHERE fname = 'Steve';
UPDATE player SET team = 'Jaguars' WHERE fname = 'Alex';
UPDATE player SET team = 'Jaguars' WHERE fname = 'Larry';
UPDATE player SET team = 'Cheetahs' WHERE fname = 'Anthony';
UPDATE player SET team = 'Cheetahs' WHERE fname = 'Patrick';

UPDATE player SET tcoach = '7132144432' WHERE fname = 'John';
UPDATE player SET tcoach = '7132144432' WHERE fname = 'Steve';
UPDATE player SET tcoach = '7137777800' WHERE fname = 'Alex';
UPDATE player SET tcoach = '7137777800' WHERE fname = 'Larry';
UPDATE player SET tcoach = '7134277765' WHERE fname = 'Anthony';
UPDATE player SET tcoach = '7134277765' WHERE fname = 'Patrick';
