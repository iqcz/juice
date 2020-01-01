CREATE TABLE T_Person
(
    FName VARCHAR(20),
    FAge  INT
);


CREATE TABLE T_Student
(
    FNumber      VARCHAR(20) NOT NULL,
    FName        VARCHAR(20) NOT NULL,
    FAge         INT         NOT NULL,
    FFavorite    VARCHAR(20),
    FPhoneNumber VARCHAR(20)
)

CREATE TABLE T_Teacher
(
    FNumber   VARCHAR(20),
    FName     VARCHAR(20),
    FAge      INT,
    FISMaster VARCHAR(5) DEFAULT 'NO'
)

CREATE TABLE T_Bus
(
    FNumber     VARCHAR(20),
    FDriverName VARCHAR(20),
    FUsedYears  INT,
    PRIMARY KEY (FNumber)
)

CREATE TABLE T_PersonalMember
(
    FCompanyName    VARCHAR(20),
    FInternalNumber VARCHAR(20),
    FName           VARCHAR(20),
    PRIMARY KEY (FCompanyName, FInternalNumber)
)

CREATE TABLE T_Department
(
    FId    VARCHAR(20),
    FName  VARCHAR(20),
    FLevel INT,
    PRIMARY KEY (FId)
)

CREATE TABLE T_Employee
(
    FNumber       VARCHAR(20),
    FName         VARCHAR(20),
    FDepartmentId VARCHAR(20),
    FOREIGN KEY (FDepartmentId) REFERENCES T_Department (FId)
)

ALTER TABLE T_PERSON
    ADD FFavorite VARCHAR(20);

ALTER
TABLET_Person DROP
FAge

DROP TABLE T_Person

