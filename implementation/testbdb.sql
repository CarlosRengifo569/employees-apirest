PGDMP         &                y            testbdb    13.3    13.3     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16448    testbdb    DATABASE     k   CREATE DATABASE testbdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE testbdb;
                postgres    false            ?            1259    16449    tbl_employee    TABLE     ?   CREATE TABLE public.tbl_employee (
    id integer NOT NULL,
    full_name character varying NOT NULL,
    function character varying NOT NULL,
    boss integer
);
     DROP TABLE public.tbl_employee;
       public         heap    postgres    false            ?          0    16449    tbl_employee 
   TABLE DATA           E   COPY public.tbl_employee (id, full_name, function, boss) FROM stdin;
    public          postgres    false    200   ?       "           2606    16456    tbl_employee PK_employeeId 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tbl_employee
    ADD CONSTRAINT "PK_employeeId" PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.tbl_employee DROP CONSTRAINT "PK_employeeId";
       public            postgres    false    200            ?   k   x?34261?tN,??/VJ?K?L??I-.I-????2Jsz?g$?%r?'?䤦?C?az|K???8???J?9Aʁ??>??y?9
???ř??y?9??%`IS?=... ?T"e     