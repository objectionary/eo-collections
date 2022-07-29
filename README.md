<img alt="logo" src="https://www.objectionary.com/cactus.svg" height="100px" />

[![EO principles respected here](https://www.elegantobjects.org/badge.svg)](https://www.elegantobjects.org)
[![DevOps By Rultor.com](http://www.rultor.com/b/objectionary/eo-collections)](http://www.rultor.com/p/objectionary/eo-collections)
[![We recommend IntelliJ IDEA](https://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)

[![mvn](https://github.com/objectionary/eo-collections/actions/workflows/mvn.yml/badge.svg?branch=master)](https://github.com/objectionary/eo-collections/actions/workflows/mvn.yml)
[![PDD status](http://www.0pdd.com/svg?name=objectionary/eo-collections)](http://www.0pdd.com/p?name=objectionary/eo-collections)
[![codecov](https://codecov.io/gh/objectionary/eo-collections/branch/master/graph/badge.svg)](https://codecov.io/gh/objectionary/eo-collections)
[![Maven Central](https://img.shields.io/maven-central/v/org.eolang/eo-collections.svg)](https://maven-badges.herokuapp.com/maven-central/org.eolang/eo-collections)

[![Hits-of-Code](https://hitsofcode.com/github/objectionary/eo-collections)](https://hitsofcode.com/view/github/objectionary/eo-collections)
![Lines of code](https://img.shields.io/tokei/lines/github/objectionary/eo-collections)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/objectionary/eo-collections/blob/master/LICENSE.txt)

[EO](https://www.eolang.org) objects for collections. The abstractions of lists, maps, sets, and others.

This is how it works:

```
eq. > @
  with.
    QQ.collections.list
      * 1 2
    3
  QQ.collections.list
    * 1 2 3
```

### List
The object `QQ.collections.list` is a decorator of `QQ.array`.

The attribute `is-empty` is TRUE if the length of the
array is zero.

The attribute `eq` is TRUE if each element of the array is equal to the corresponding element of another array and the lengths of both arrays are the same.

The attribute `without` is a new array with the i-th element removed.

The attributes `each`, `reduce`, and `map` are respectively similar to forEach, reduce, find, reduce, and map methods of Array object in JavaScript (ECMA, 2011). 
A few “twin” attributes `reducedi`,  and `mapi`are semantically the same, but with an extra int argument as a counter of a cycle.
The attribute `slice` is a part of the array.

```
[] > list-test
  QQ.hamcrest.assert-that > @
    reducei.
      QQ.collections.list
        * TRUE TRUE FALSE
      TRUE
      [a i x]
        and. > @
          x
          a
    $.equal-to FALSE
```

### Map

The object `QQ.collections.map` is a decorator of `QQ.array` of pairs (_k_, _v_).
The map ensures that all _k_ are always unique. It is expected that each _k_ has `as-hash` attribute that behaves as `int`.
The attributes `with`, `without`, `found`, and `foundi` are reimplemented in `map`.

```
[] > map-test
  QQ.hamcrest.assert-that > @
    at.
      found.
        with.
          QQ.collections.map *
          1
          "a"
        1
      0
    $.equal-to "a"
```

## How to Contribute

Fork repository, make changes, send us a pull request.
We will review your changes and apply them to the `master` branch shortly,
provided they don't violate our quality standards. To avoid frustration,
before sending us your pull request please run full Maven build:

```bash
$ mvn clean install -Pqulice
```

You will need Maven 3.3+ and Java 8+.

