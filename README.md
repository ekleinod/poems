# Poems

XML-Schema und Programme für Gedichte.

XML schema and programs for poems.


## Libraries

Ich verwende folgende Libraries via *maven*:

I am using other libraries in this project (via *maven*):

- edgeutils
	- Hilfsklassen
	- utility classes
	- license: GNU Lesser General Public License 3
- Freemarker
- JUnit
	- unit testing framework
	- license: Eclipse Public License, Version 1.0, see https://www.eclipse.org/legal/epl-v10.html
- JAXB

## Git-Repository

Ich strukturiere das Git-Repository wie im Branching-Modell von http://nvie.com/posts/a-successful-git-branching-model/ vorgeschlagen.
Das bedeutet, es gibt immer die folgenden drei Branches:

The branches are constructed regarding the git branching model of http://nvie.com/posts/a-successful-git-branching-model/
This means, there are always at least three branches:

1. `master` - fertige Versionen (contains released versions)
2. `develop` - Synchronisierungbranch (main synchronisation branch for feature, release, and hotfix branches)
3. `feature/work` - Hauptarbeitsbranch (main working branch for development)

Zusätzlich können folgende Branches auftauchen:

Additionally, the following branches my occur:

- `feature/*` - Features (writing a special feature)
- `release/*` - Release-Synchronisierung (synchronizing release versions between `develop` and `master`)
- `hotfix/*` - Fehlerbehebung (fast bugfixes)

## Copyright

Copyright 2016-2016 Ekkart Kleinod <ekleinod@edgesoft.de>

The program is distributed under the terms of the GNU Lesser General Public License.

See COPYING and COPYING.LESSER for details.

This file is part of poems.

poems is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

poems is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with poems.  If not, see <http://www.gnu.org/licenses/>.

