ALTER table clinics
DROP COLUMN leftTitle,
DROP COLUMN rightTitle;

ALTER table clinics
ADD COLUMN left_title varchar(50),
ADD COLUMN right_title varchar(50);