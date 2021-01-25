# Database
SQL scripts that can be executed to reproduce the database object definitions and table data. 
## Requirements 
**MySQL server**
```
https://dev.mysql.com/downloads/installer/
```
## Usage
Inside mysql command prompt:
First create database:
```
CREATE DATABASE kortyapp;
```
Recreate users:
```
source recreateUsers.sql
```
Switch to the database:
```
use kortyapp
```
Since we have some polish letters inside sample dump we need to:
```
SET names 'utf8';
```
Run Program

```
Seed data:
```
source sampleDataDump.sql
```