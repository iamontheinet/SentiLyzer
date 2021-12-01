# SentiLyzer

Java project that contains static methods that can be called from Snowpark for performing sentiment analysis on text using [CoreNLP](https://stanfordnlp.github.io/CoreNLP/).

## Usage

### Step 1

After cloning the project, run `mvn package`. If all goes well, this will create **SentiLyzer-1.0-SNAPSHOT-jar-with-dependencies.jar** in the target folder.


### Step 2

Use the [Snowflake CLI](https://docs.snowflake.com/en/user-guide/snowsql.html) to upload the jar once it is compiled locally. Follow the instructions here to install the [Snowflake CLI](https://docs.snowflake.com/en/user-guide/snowsql-install-config.html).


### Step 3

3.a Start a SnowSQL session at the command line by running `snowsql -a <YOUR_SNOWFLAKE_ACCOUNT> -u <YOUR_USER_NAME>`


3.b Set the database, schema, and warehouse by running the following command.

```
use database <YOUR_DATABASE>;
use schema <YOUR_SCHEMA>;
use warehouse <YOUR_WAREHOUSE>;
```

3.c Upload the jar to Snowflake by running the following command.


```
put file:///<full-path>/target/SentiLyzer-1.0-SNAPSHOT-jar-with-dependencies.jar
@~/<YOUR_SNOWFLAKE_STAGE_NAME>/
auto_compress = false
overwrite = true;
```

3.d Create the UDF in Snowflake by running the following command.


```
create or replace function sentiment_analysis(s varchar)
returns numeric
language java
imports = ('@~/<YOUR_SNOWFLAKE_STAGE_NAME>/SentiLyzer-1.0-SNAPSHOT-jar-with-dependencies.jar')
handler = 'com.dash.analyzer.AnalyzeSentiment.sentiment_analysis';
```

### Step 4

Use the `sentiment_analysis` UDF in your SQL queries in Snowflake. For example, to score reviews from AMAZON_REVIEWS table in Snowflake:

```sql
SELECT REVIEW, sentiment_analysis(REVIEW) as SCORE 
FROM AMAZON_REVIEWS;
```
