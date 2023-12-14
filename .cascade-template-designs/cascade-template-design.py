import re

import sys
 
fileToUpdate = sys.argv[1]

print(fileToUpdate)

temporaryReplaceStringBegin="22222"

temporaryReplaceStringEnd="44444"

def replaceTemplateHTMLHead():

	templateSectionBegin="!-- html / head / css / begin -->"

	templateSectionEnd="<!-- html / head / css / end -->"

	with open('../.template-parts/html-head-css.part.template') as templateContentFile:

		contentToSubstituteIntoArea = templateContentFile.read()

	with open(fileToUpdate) as targetSubstitutionFile:
		s = targetSubstitutionFile.read()

	ddd=s

	ddd=re.sub(templateSectionBegin, templateSectionBegin+temporaryReplaceStringBegin, ddd, flags=re.DOTALL)

	ddd=re.sub(templateSectionEnd, temporaryReplaceStringEnd+templateSectionEnd, ddd, flags=re.DOTALL)
	ddd=re.sub(temporaryReplaceStringBegin+".*"+temporaryReplaceStringEnd,contentToSubstituteIntoArea,ddd,flags=re.DOTALL)

	f = open(fileToUpdate, "w")
	
	f.write(ddd)
	
	f.close()

def replaceTemplateBodySidebar():

	templateSectionBegin="!-- html / body / menu / sidebar / begin -->"

	templateSectionEnd="<!-- html / body / menu / sidebar / end -->"

	with open('../.template-parts/html-menu-sidebar.part.template') as templateContentFile:

		contentToSubstituteIntoArea = templateContentFile.read()

	with open(fileToUpdate) as targetSubstitutionFile:
		s = targetSubstitutionFile.read()

	ddd=s

	ddd=re.sub(templateSectionBegin, templateSectionBegin+temporaryReplaceStringBegin, ddd, flags=re.DOTALL)

	ddd=re.sub(templateSectionEnd, temporaryReplaceStringEnd+templateSectionEnd, ddd, flags=re.DOTALL)
	ddd=re.sub(temporaryReplaceStringBegin+".*"+temporaryReplaceStringEnd,contentToSubstituteIntoArea,ddd,flags=re.DOTALL)

	f = open(fileToUpdate, "w")
	
	f.write(ddd)
	
	f.close()


def replaceTemplateBodyJavascript():

	templateSectionBegin="<!-- html / body / javascript / begin -->"

	templateSectionEnd="<!-- html / body / javascript / end -->"

	with open('../.template-parts/html-body-javascript.part.template') as templateContentFile:

		contentToSubstituteIntoArea = templateContentFile.read()

	with open(fileToUpdate) as targetSubstitutionFile:
		s = targetSubstitutionFile.read()

	ddd=s

	ddd=re.sub(templateSectionBegin, templateSectionBegin+temporaryReplaceStringBegin, ddd, flags=re.DOTALL)

	ddd=re.sub(templateSectionEnd, temporaryReplaceStringEnd+templateSectionEnd, ddd, flags=re.DOTALL)
	ddd=re.sub(temporaryReplaceStringBegin+".*"+temporaryReplaceStringEnd,contentToSubstituteIntoArea,ddd,flags=re.DOTALL)

	f = open(fileToUpdate, "w")
	
	f.write(ddd)
	
	f.close()

###################################################################
##
## driver
##
###################################################################


replaceTemplateHTMLHead()

replaceTemplateBodySidebar()

replaceTemplateBodyJavascript()
