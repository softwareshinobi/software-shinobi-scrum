import re

import sys
 
fileToUpdate = sys.argv[1]

print(fileToUpdate)

temporaryReplaceStringBegin="22222"

temporaryReplaceStringEnd="44444"

def replaceTemplateContentHeader():

	templateSectionBegin="!-- template / html / head / begin -->"

	templateSectionEnd="<!-- template / html / head / end -->"

	with open('../.template-parts/template-content.header') as templateContentFile:
		contentToSubstituteIntoArea = templateContentFile.read()
	##	print(contentToSubstituteIntoArea)

	with open(fileToUpdate) as targetSubstitutionFile:
		s = targetSubstitutionFile.read()
		
		##print("s: ")
	##	print(s)

	ddd=s

	ddd=re.sub(templateSectionBegin, templateSectionBegin+temporaryReplaceStringBegin, ddd, flags=re.DOTALL)

	ddd=re.sub(templateSectionEnd, temporaryReplaceStringEnd+templateSectionEnd, ddd, flags=re.DOTALL)

##	print("ddd: ")
##	print(ddd)
	ddd=re.sub(temporaryReplaceStringBegin+".*"+temporaryReplaceStringEnd,contentToSubstituteIntoArea,ddd,flags=re.DOTALL)

##	print("final: ")
##	print(ddd)

	f = open(fileToUpdate, "w")
	
	f.write(ddd)
	
	f.close()

def replaceTemplateContentMenu():

	templateSectionBegin="<!-- Template Menu // Begin -->"

	templateSectionEnd="<!-- Template Menu // End -->"

	temporaryReplaceStringBegin="22222"

	temporaryReplaceStringEnd="44444"

	with open('../.template-parts/template-content.menu') as templateContentFile:
		contentToSubstituteIntoArea = templateContentFile.read()
	##	print(contentToSubstituteIntoArea)

	with open(fileToUpdate) as targetSubstitutionFile:
		s = targetSubstitutionFile.read()
		
	##	print("s: ")
##		print(s)

	ddd=s

	ddd=re.sub(templateSectionBegin, templateSectionBegin+temporaryReplaceStringBegin, ddd, flags=re.DOTALL)

	ddd=re.sub(templateSectionEnd, temporaryReplaceStringEnd+templateSectionEnd, ddd, flags=re.DOTALL)

##	print("ddd: ")
	##print(ddd)

	ddd=re.sub(temporaryReplaceStringBegin+".*"+temporaryReplaceStringEnd,contentToSubstituteIntoArea,ddd,flags=re.DOTALL)

##	print("final: ")
##	print(ddd)

	f = open(fileToUpdate, "w")
	f.write(ddd)
	f.close()

def replaceTemplateContentFooter():

	templateSectionBegin="<!-- Footer // Begin -->"

	templateSectionEnd="<!-- Footer // End -->"

	temporaryReplaceStringBegin="22222"

	temporaryReplaceStringEnd="44444"

	with open('../.template-parts/template-content.footer') as templateContentFile:
		contentToSubstituteIntoArea = templateContentFile.read()
	##	print(contentToSubstituteIntoArea)

	with open(fileToUpdate) as targetSubstitutionFile:
		s = targetSubstitutionFile.read()
		
	##	print("s: ")
		##print(s)

	ddd=s

	ddd=re.sub(templateSectionBegin, templateSectionBegin+temporaryReplaceStringBegin, ddd, flags=re.DOTALL)

	ddd=re.sub(templateSectionEnd, temporaryReplaceStringEnd+templateSectionEnd, ddd, flags=re.DOTALL)

	print("ddd: ")
	print(ddd)

	ddd=re.sub(temporaryReplaceStringBegin+".*"+temporaryReplaceStringEnd,contentToSubstituteIntoArea,ddd,flags=re.DOTALL)

##	print("final: ")
##	print(ddd)

	f = open(fileToUpdate, "w")
	f.write(ddd)
	f.close()

replaceTemplateContentHeader()

replaceTemplateContentMenu()

replaceTemplateContentFooter()
