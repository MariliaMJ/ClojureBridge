(ns cipher.core-test
  (:require [clojure.test :refer :all]
            [cipher.core :as core]
            [midje.sweet :refer :all]))

(facts "takes a lowercase letter character and returns its position in the alphabet: a = 0, b = 1, etc"
       (tabular
         (core/to-int ?char) => ?result
         ?char ?result
         \a    0
         \b    1
         \c    2
         \d    3
         \e    4
         \f    5
         \g    6
         \h    7
         \i    8
         \j    9
         \k    10
         \l    11
         \m    12
         \n    13
         \o    14
         \p    15
         \q    16
         \r    17
         \s    18
         \t    19
         \u    20
         \v    21
         \w    22
         \x    23
         \y    24
         \z    25))

(facts "receives a number and returns a letter"
       (tabular
         (core/to-char ?integer) => ?result
         ?integer  ?result
         0        \a
         1        \b
         2        \c
         3        \d
         4        \e
         5        \f
         6        \g
         7        \h
         8        \i
         9        \j
         10       \k
         11       \l
         12       \m
         13       \n
         14       \o
         15       \p
         16       \q
         17       \r
         18       \s
         19       \t
         20       \u
         21       \v
         22       \w
         23       \x
         24       \y
         25       \z ))

(facts "should return shifted letters by a factor of n"
       (tabular
         (core/shift-letters ?char ?n) => ?result
         ?char ?n ?result
         \a     2   \c
         \b     2   \d
         \c     2   \e
         \a     3   \d
         \b     3   \e
         \c     3   \f))
(facts "should encrypt a word using caesar method"
       (tabular
         (core/caesar-encrypt ?word ?n) => ?encryption
         ?word ?n ?encryption
         "apple" 2  "crrng"))

(facts "should decrypt a word using caesar method"
       (tabular
         (core/caesar-decrypt ?word ?n) => ?encryption
         ?word ?n ?encryption
         "crrng" 2  "apple"))
(facts "should return a string of of only letters in it, all letters converted to lowercase"
       (tabular
         (core/get-letters ?word) => ?result
         ?word            ?result
         "Hello, World!"  "helloworld"))
(facts "should count the occurrence of a given letter in a word"
       (tabular
         (core/count-letters ?word ?letter) => ?result
         ?word            ?letter ?result
         "absynth"        \a      1
         "incredible"     \e      2
         "articulated"    \o      0
         "constitutional" \t      3))

(facts "should return a hashmap with the letters frequencies"
       (core/letter-frequencies "avocado") => {"a" 2, "v" 1, "o" 2, "c" 1, "d" 1})